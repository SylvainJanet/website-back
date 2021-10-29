package fr.sylvainjanet.personal_website.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sylvainjanet.personal_website.dto.entities.LanguagedStringDto;
import fr.sylvainjanet.personal_website.entities.LanguagedString;
import fr.sylvainjanet.personal_website.repositories.LanguagedStringRepository;
import fr.sylvainjanet.personal_website.services.interfaces.ILanguagedStringService;

@Service
@Transactional
public class LanguagedStringService extends GenericService<LanguagedString, LanguagedStringDto>
		implements ILanguagedStringService {

	public LanguagedStringService(@Autowired LanguagedStringRepository languagedStringRepository) {
		super(LanguagedStringDto.class, languagedStringRepository);
	}

}
