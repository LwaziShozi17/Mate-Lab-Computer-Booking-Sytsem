package za.ac.cput.service;

// Center class for CRUD operations

public interface IService <T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
