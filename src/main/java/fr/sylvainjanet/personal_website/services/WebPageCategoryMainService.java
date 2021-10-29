package fr.sylvainjanet.personal_website.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sylvainjanet.personal_website.dto.entities.WebPageCategoryMainDto;
import fr.sylvainjanet.personal_website.entities.WebPageCategoryMain;
import fr.sylvainjanet.personal_website.repositories.WebPageCategoryMainRepository;
import fr.sylvainjanet.personal_website.services.interfaces.IWebPageCategoryMainService;

@Service
@Transactional
public class WebPageCategoryMainService extends GenericService<WebPageCategoryMain, WebPageCategoryMainDto>
		implements IWebPageCategoryMainService {

	public WebPageCategoryMainService(@Autowired WebPageCategoryMainRepository webPageCategoryRepository) {
		super(WebPageCategoryMainDto.class, webPageCategoryRepository);
	}

}
