package org.aamc.twttr.test;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractValidationTest<T> extends BaseTest {
	@Autowired
	protected Validator validator;
	
	private Set<ConstraintViolation<T>> violations;
	
	public void validate(T t) {
		violations = validator.validate(t);
	}
	
	public Set<ConstraintViolation<T>> getViolations() {
		return violations;
	}

	public void assertValid(T t) {
		assertTrue(isValid(t));
	}

	public void assertInvalid(T t) {
		assertTrue(!isValid(t));
	}

	private boolean isValid(T t) {
		validate(t);
		return (violations.size() == 0);

	}

}
