package com.example.jpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile"))
})
public class Guardian {

    private String name;
    private String email;
    private String mobile;

    public Guardian() {

    }
}
