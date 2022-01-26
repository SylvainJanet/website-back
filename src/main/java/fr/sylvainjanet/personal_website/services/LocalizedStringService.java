package fr.sylvainjanet.personal_website.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sylvainjanet.personal_website.dto.entities.LocalizedStringDto;
import fr.sylvainjanet.personal_website.entities.LocalizedString;
import fr.sylvainjanet.personal_website.repositories.LocalizedStringRepository;
import fr.sylvainjanet.personal_website.services.interfaces.ILocalizedStringService;

@Service
@Transactional
public class LocalizedStringService extends GenericService<LocalizedString, LocalizedStringDto>
		implements ILocalizedStringService {

	public LocalizedStringService(@Autowired LocalizedStringRepository localizedStringRepository) {
		super(LocalizedStringDto.class, localizedStringRepository);
	}

}
