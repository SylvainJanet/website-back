package fr.sylvainjanet.personal_website.dto.tools;

import org.modelmapper.ModelMapper;

import fr.sylvainjanet.personal_website.dto.entities.WebsiteMainMenuDto;
import fr.sylvainjanet.personal_website.dto.entities.WebsiteMainMenuItemDto;
import fr.sylvainjanet.personal_website.dto.entities.partial.WebsiteMainMenuItemDtoLevel1;
import fr.sylvainjanet.personal_website.dto.entities.partial.WebsiteMainMenuItemDtoLevel2;
import fr.sylvainjanet.personal_website.dto.tools.converters.WebsiteMainMenuItemToDtoConverter;
import fr.sylvainjanet.personal_website.dto.tools.converters.WebsiteMainMenuItemToDtoLevel1Converter;
import fr.sylvainjanet.personal_website.dto.tools.converters.WebsiteMainMenuItemToDtoLevel2Converter;
import fr.sylvainjanet.personal_website.dto.tools.converters.WebsiteMainMenuToDtoConverter;
import fr.sylvainjanet.personal_website.entities.WebsiteMainMenu;
import fr.sylvainjanet.personal_website.entities.WebsiteMainMenuItem;

public class DtoTools {

	public static <TSource, TDestination> TDestination convert(TSource obj, Class<TDestination> clazz) {
		ModelMapper myMapper = new ModelMapper();

		myMapper.createTypeMap(WebsiteMainMenuItem.class, WebsiteMainMenuItemDto.class)
				.addMappings(mapper -> mapper.using(new WebsiteMainMenuItemToDtoConverter())
						.map(WebsiteMainMenuItem::getSubitems, WebsiteMainMenuItemDto::setSubitemsIds));

		myMapper.createTypeMap(WebsiteMainMenu.class, WebsiteMainMenuDto.class)
				.addMappings(mapper -> mapper.using(new WebsiteMainMenuToDtoConverter()).map(WebsiteMainMenu::getItems,
						WebsiteMainMenuDto::setItems));

		myMapper.createTypeMap(WebsiteMainMenuItem.class, WebsiteMainMenuItemDtoLevel1.class)
				.addMappings(mapper -> mapper.using(new WebsiteMainMenuItemToDtoLevel1Converter())
						.map(WebsiteMainMenuItem::getSubitems, WebsiteMainMenuItemDtoLevel1::setSubitems));

		myMapper.createTypeMap(WebsiteMainMenuItem.class, WebsiteMainMenuItemDtoLevel2.class)
				.addMappings(mapper -> mapper.using(
						new WebsiteMainMenuItemToDtoLevel2Converter())
						.map(WebsiteMainMenuItem::getSubitems, WebsiteMainMenuItemDtoLevel2::setSubitems));
		return myMapper.map(obj, clazz);
	}

}