package veroslaves.upcoming_events_back.interfaces;

import java.util.List;

public interface IGenericLimitedService<T> {
    public List<T> getAll();
    public T getById(Long id) throws Exception;
    public T save(T obj);
    void deleteById(Long id) throws Exception;

}
