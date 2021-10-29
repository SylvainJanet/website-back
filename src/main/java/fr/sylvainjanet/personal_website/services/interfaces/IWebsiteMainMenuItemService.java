package fr.sylvainjanet.personal_website.services.interfaces;

import java.util.List;

import fr.sylvainjanet.personal_website.dto.entities.WebsiteMainMenuItemDto;
import fr.sylvainjanet.personal_website.dto.entities.partial.WebsiteMainMenuItemDtoLevel1;
import fr.sylvainjanet.personal_website.dto.entities.partial.WebsiteMainMenuItemDtoLevel2;
import fr.sylvainjanet.personal_website.services.IGenericService;

public interface IWebsiteMainMenuItemService extends IGenericService<WebsiteMainMenuItemDto> {

	List<WebsiteMainMenuItemDtoLevel1> getAllLevel1();

	List<WebsiteMainMenuItemDtoLevel2> getAllLevel2();
}
