package com.orangeven.qiafan.app.customer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.orangeven.qiafan.app.common.enumeration.Gender;
import com.orangeven.qiafan.app.common.model.AbstractLoginableEntityModel;

@Entity
@Table(name = "customer")
public class Customer extends AbstractLoginableEntityModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2650069057418494055L;
	@Id
    @SequenceGenerator(
            name = "customer_id_generator",
            sequenceName = "customer_id_seq",
            initialValue = 100,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_generator"
    )
    private Long id;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String email;
    private String nickname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
