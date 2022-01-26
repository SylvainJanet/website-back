package fr.sylvainjanet.personal_website.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sylvainjanet.personal_website.dto.entities.PageDto;
import fr.sylvainjanet.personal_website.entities.Page;
import fr.sylvainjanet.personal_website.repositories.PageRepository;
import fr.sylvainjanet.personal_website.services.interfaces.IPageService;

@Service
@Transactional
public class PageService extends GenericService<Page, PageDto> implements IPageService {

	public PageService(@Autowired PageRepository pageRepository) {
		super(PageDto.class, pageRepository);
	}

}
