package DataAccessObject;

   public interface IBaseDAO<T> {
   public boolean Create(T input);
   public boolean Update(T input);
   public boolean Delete(String input);
   public T Read(String input);
}

    