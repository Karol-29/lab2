import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Relation {
    private String[] attributes;
    private List<String[]> tuples;
    private Set<String[]> uniqueTuples;
    private boolean valid;

    public Relation(String[] attributes) {
        this.attributes = attributes;
        this.tuples = new ArrayList<>();
        this.uniqueTuples = new HashSet<>();

        // Verificar si hay atributos duplicados
        Set<String> attributeSet = new HashSet<>(Arrays.asList(attributes));
        this.valid = attributeSet.size() == attributes.length;
    }

    public Relation insert(String[] tuple) {
        if (valid && tuple.length == attributes.length) {
            // Si la tupla no está en el conjunto, se inserta
            if (!in(tuple)) {
                tuples.add(tuple);
                uniqueTuples.add(tuple);
            }
        }
        return this;
    }

    public int columns() {
        return valid ? attributes.length : 0;
    }

    public int tuples() {
        return tuples.size();
    }

    public boolean in(String[] tuple) {
        for (String[] t : tuples) {
            if (areTuplesEqual(t, tuple)) {
                return true;
            }
        }
        return false;
    }

    // Método para comparar las tuplas de manera insensible a mayúsculas/minúsculas
    private boolean areTuplesEqual(String[] t1, String[] t2) {
        if (t1.length != t2.length) {
            return false;
        }
        for (int i = 0; i < t1.length; i++) {
            if (!t1[i].equalsIgnoreCase(t2[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Relation)) {
            return false;
        }
        Relation otherRelation = (Relation) other;
        return Arrays.equals(this.attributes, otherRelation.attributes) &&
               this.tuples.equals(otherRelation.tuples);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String attr : attributes) {
            sb.append(attr).append("\t");
        }
        sb.append("\n");
        for (String[] tuple : tuples) {
            for (String field : tuple) {
                sb.append(field).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}


