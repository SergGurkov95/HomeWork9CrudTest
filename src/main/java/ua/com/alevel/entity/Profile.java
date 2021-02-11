package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profile extends AbstractEntity{

    private String profileName;
    private String lastName;

    public Profile(){
        super();
    }
}
