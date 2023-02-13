package Ejercicio1;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Liga{
    public static void main(String[] args) {
        Partido n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12;
        Set<Partido> partidos = new Set<Partido>() {
            @Override
            public int size() {
                return 0;
            }
            @Override
            public boolean isEmpty() {
                return false;
            }
            @Override
            public boolean contains(Object o) {
                return false;
            }
            @Override
            public Iterator<Partido> iterator() {
                return null;
            }
            @Override
            public Object[] toArray() {
                return new Object[0];
            }
            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }
            @Override
            public boolean add(Partido partido) {
                return false;
            }
            @Override
            public boolean remove(Object o) {
                return false;
            }
            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }
            @Override
            public boolean addAll(Collection<? extends Partido> c) {
                return false;
            }
            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }
            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }
            @Override
            public void clear() {

            }
        };

        n1 = new Partido(3, 5);
        n2 = new Partido(3, 5);
        n3 = new Partido(3, 5);
        n4 = new Partido(3, 5);
        n5 = new Partido(3, 5);
        n6 = new Partido(3, 5);
        n7 = new Partido(3, 5);
        n8 = new Partido(3, 5);
        n9 = new Partido(3, 5);
        n10 = new Partido(3, 5);
        n11 = new Partido(3, 5);
        n12 = new Partido(3, 5);

        partidos.add(n1);
        partidos.add(n2);
        partidos.add(n3);
        partidos.add(n4);
        partidos.add(n5);
        partidos.add(n6);
        partidos.add(n7);
        partidos.add(n8);
        partidos.add(n9);
        partidos.add(n10);
        partidos.add(n11);
        partidos.add(n12);

        Iterator<Partido> iterato = partidos.iterator();

        while (iterato.hasNext()) {
            System.out.println(iterato.next());
        }
    }
}
