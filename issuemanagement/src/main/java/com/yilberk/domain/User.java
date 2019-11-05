package com.yilberk.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "username", length = 100, unique = true)
	private String username;
	
	@Column(name = "password", length = 200)
	private String password;
	
	@Column(name = "name_surname", length = 200)
	private String nameSurname;
	
	@Column(name = "email", length = 100)
	private String email;
	
	@OneToMany(fetch= FetchType.LAZY)
	@JoinColumn(name = "assignee_user_id")
	private List<Issue> issues;

}
