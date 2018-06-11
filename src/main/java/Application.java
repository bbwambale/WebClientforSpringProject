import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


public class Application {


    public static void main(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String receivedData = restTemplate.getForObject("http://localhost:8080/api/person", String.class);
        ObjectMapper mapper = new ObjectMapper();
        Person[] persons= mapper.readValue(receivedData, Person[].class);
        System.out.println("List of all Persons Who visited Coffee Shop");
        for (Person p : persons) {
            System.out.println("Person Id: " + p.getId() + " Person Name: " + p.getFirstName() +
                    " Email: " + p.getEmail());
        }

        receivedData = restTemplate.getForObject("http://localhost:8080/api/person/" + 9, String.class);
        System.out.println("Get Person By ID from Coffee Shop DB");
        Person person  = mapper.readValue(receivedData, Person.class);
        System.out.println("List of all Persons Who visited Coffee Shop");
        for (Person p : persons) {
            System.out.println("Person Id: " + p.getId() + " Person Name: " + p.getFirstName() +
                    " Email: " + p.getEmail());
        }
    }

}
