package com.baggiovictor.email.repositories;

import com.baggiovictor.email.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public class EmailRepository extends JpaRepository<EmailModel, Long> {

}
