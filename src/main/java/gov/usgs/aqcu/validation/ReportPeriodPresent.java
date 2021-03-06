package gov.usgs.aqcu.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { ReportPeriodPresentValidator.class })
public @interface ReportPeriodPresent {

	String message() default "Missing information required to build report time period. Must include at least one of: [lastMonths, waterYear, {startDate, endDate}].";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
