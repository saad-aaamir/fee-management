package org.rak.fee.unit.fee;

import jakarta.persistence.*;

/**
 * @author Usman
 * @created 1/23/2024 - 12:51 AM
 * @project Microservices-assessment
 */
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "fee")
public class Fee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "uuid") private String uuid;
	@Column(name = "description") private String description;
	@Column(name = "type") private String type;
	@Column(name = "sub_category") private String subCategory;
	@Column(name = "frequency") private String frequency;
	@Column(name = "category") private String category;
	@Column(name = "amount") private String amount;

}
