package timeadekany.pet;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class Pet {
    private BigInteger id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;
}

