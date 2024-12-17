package programma.DB;

import java.util.List;

public interface Crud<T>{
    // T mag je invullen bij het implementeren van een class die Crud gaat gebruiken.
    public void create(T params);

    public T get(int id);
    // methode om alles terug te krijgen
    public List<T> get();

    public void update(int id, String params);

    public void delete(int id);

}