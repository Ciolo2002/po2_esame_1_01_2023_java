public interface Resource<T> {
    T get(); // getter dell'oggetto di tipo T
    void autorelease(); // rilascia questo oggetto e lo rimette nella pool da cui proviene
}
