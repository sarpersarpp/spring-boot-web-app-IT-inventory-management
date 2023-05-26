package project.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import project.app.model.Item;

@Component
public class FieldMatchValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Item item = (Item)target;
		if(item.getId()<-1) {
			errors.rejectValue("id","Cannot be null value!");
		}
		if(item.getItemQuantity()== 0) {
			errors.rejectValue( "ItemQuantity", "NotNull.Item.itemQuantity");
		}
	}

}
