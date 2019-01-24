package kata7.model;

public interface Observer<T extends Observable> {
	
	void notify(T observable);

}
