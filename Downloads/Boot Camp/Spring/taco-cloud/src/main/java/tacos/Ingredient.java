package tacos;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

import lombok.Data;

@Data
@Entity
public class Ingredient implements Persistable<String> {
	@Id
	private String id;
	private String name;
	private Type type;
	
	public Ingredient(String id, String name, Type type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public Ingredient() {
		super();
	}

	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}
	@Override
	public boolean isNew() {
		return true;
	}	
}