package hackathon.nttdata.coderpath.preguntas.controller.validation;


import javax.validation.Validator;
import hackathon.nttdata.coderpath.preguntas.documents.Preguntas;
import reactor.core.publisher.Mono;

public class CustomerValidator implements BaseValidator<Preguntas> {

	@Override
	public Mono<Preguntas> validate(Preguntas t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	  /**
	  
	 
	private final Validator<Cursos> validator;
	  
	  public CustomerValidator(){ validator =
	  ValidatorBuilder.of(Cursos.class)
	  .constraint(Cursos::getCompanyEmail, "companyEmail", c->
	  c.notNull().email()).constraint(Cursos::getCompanyName,
	  "companyName", c -> c.notNull()) .constraint(CustomerModel::getTaxId,
	  "taxId", c -> c.pattern("")) .build(); }
	  
	  @Override public Mono<CustomerModel> validate(CustomerModel model) {
	  ConstraintViolations violations = CustomerValidator.validate(model); if
	  (violations.isValid()) { return Mono.just(model); } else { return
	  Mono.error(new ValidationException(violations.violations())); } }
	 
	**/

}
