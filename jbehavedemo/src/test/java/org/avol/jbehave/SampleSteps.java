package org.avol.jbehave;

import org.avol.jbehave.dao.impl.SampleDaoImpl;
import org.avol.jbehave.service.Sample;
import org.avol.jbehave.service.impl.SampleImpl;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertTrue;

/**
 * Created by lovababu on 09/09/18.
 */
public class SampleSteps {

    private Sample sample;

    private String output;

    @Given("a system has been initialized")
    public void a_system_has_been_initialized() {
        sample = new SampleImpl(new SampleDaoImpl());
    }

    @When("the great request sent with user $username")
    public void the_great_request_sent_with_user(@Named("username") String username) {
        this.output = sample.greet(username);
    }

    @Then("the response should contains $username")
    public void the_response_should_contains(@Named("username") String username) {
        assertTrue(output.contains(username));
    }

}
