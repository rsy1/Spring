package tacos;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
@Entity
public class Taco {

	public Taco() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date createdAt = new Date();

	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;

	@ManyToMany()
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private ArrayList<IngredientRef> ingredients = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<IngredientRef> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<IngredientRef> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngredient(Ingredient taco) {
		this.ingredients.add(new IngredientRef(taco.getId()));
	}
}