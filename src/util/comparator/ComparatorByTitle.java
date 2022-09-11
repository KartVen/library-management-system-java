package util.comparator;

import model.Publication;

import java.util.Comparator;

public class ComparatorByTitle implements Comparator<Publication> {
    @Override
    public int compare(Publication pub1, Publication pub2) {
        if (pub1 == null && pub2 == null) return 0;
        if (pub1 == null) return 1;
        if (pub2 == null) return -1;
        return pub1.getTitle().compareToIgnoreCase(pub2.getTitle());
    }
}
