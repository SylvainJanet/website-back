package fr.sylvainjanet.personal_website.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sylvainjanet.personal_website.dto.entities.WebsiteMainMenuItemDto;
import fr.sylvainjanet.personal_website.dto.entities.partial.WebsiteMainMenuItemDtoLevel1;
import fr.sylvainjanet.personal_website.dto.entities.partial.WebsiteMainMenuItemDtoLevel2;
import fr.sylvainjanet.personal_website.dto.tools.DtoTools;
import fr.sylvainjanet.personal_website.entities.WebsiteMainMenuItem;
import fr.sylvainjanet.personal_website.repositories.WebsiteMainMenuItemRepository;
import fr.sylvainjanet.personal_website.services.interfaces.IWebsiteMainMenuItemService;

@Service
@Transactional
public class WebsiteMainMenuItemService extends GenericService<WebsiteMainMenuItem, WebsiteMainMenuItemDto>
		implements IWebsiteMainMenuItemService {

	public WebsiteMainMenuItemService(@Autowired WebsiteMainMenuItemRepository websiteMainMenuItemRepository) {
		super(WebsiteMainMenuItemDto.class, websiteMainMenuItemRepository);
	}

	@Override
	public List<WebsiteMainMenuItemDtoLevel1> getAllLevel1() {
		List<WebsiteMainMenuItem> lst = tRepository.findAll();
		List<WebsiteMainMenuItemDtoLevel1> result = new ArrayList<WebsiteMainMenuItemDtoLevel1>();
		for (WebsiteMainMenuItem t : lst) {
			result.add(DtoTools.convert(t, WebsiteMainMenuItemDtoLevel1.class));
		}
		return result;
	}

	@Override
	public List<WebsiteMainMenuItemDtoLevel2> getAllLevel2() {
		List<WebsiteMainMenuItem> lst = tRepository.findAll();
		List<WebsiteMainMenuItemDtoLevel2> result = new ArrayList<WebsiteMainMenuItemDtoLevel2>();
		for (WebsiteMainMenuItem t : lst) {
			result.add(DtoTools.convert(t, WebsiteMainMenuItemDtoLevel2.class));
		}
		return result;
	}

}
