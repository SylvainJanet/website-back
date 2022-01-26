package fr.sylvainjanet.personal_website.dto.tools;

import org.modelmapper.ModelMapper;

import fr.sylvainjanet.personal_website.dto.entities.MenuDto;
import fr.sylvainjanet.personal_website.dto.entities.MenuItemDto;
import fr.sylvainjanet.personal_website.dto.entities.partial.MenuItemDtoLevel1;
import fr.sylvainjanet.personal_website.dto.entities.partial.MenuItemDtoLevel2;
import fr.sylvainjanet.personal_website.dto.tools.converters.MenuItemToDtoConverter;
import fr.sylvainjanet.personal_website.dto.tools.converters.MenuItemToDtoLevel1Converter;
import fr.sylvainjanet.personal_website.dto.tools.converters.MenuItemToDtoLevel2Converter;
import fr.sylvainjanet.personal_website.dto.tools.converters.MenuToDtoConverter;
import fr.sylvainjanet.personal_website.entities.Menu;
import fr.sylvainjanet.personal_website.entities.MenuItem;

public class DtoTools {

	public static <TSource, TDestination> TDestination convert(TSource obj, Class<TDestination> clazz) {
		ModelMapper myMapper = new ModelMapper();

		myMapper.createTypeMap(MenuItem.class, MenuItemDto.class).addMappings(mapper -> mapper
				.using(new MenuItemToDtoConverter()).map(MenuItem::getSubItems, MenuItemDto::setSubItemsIds));

		myMapper.createTypeMap(Menu.class, MenuDto.class)
				.addMappings(mapper -> mapper.using(new MenuToDtoConverter()).map(Menu::getItems, MenuDto::setItems));

		myMapper.createTypeMap(MenuItem.class, MenuItemDtoLevel1.class).addMappings(mapper -> mapper
				.using(new MenuItemToDtoLevel1Converter()).map(MenuItem::getSubItems, MenuItemDtoLevel1::setSubItems));

		myMapper.createTypeMap(MenuItem.class, MenuItemDtoLevel2.class).addMappings(mapper -> mapper
				.using(new MenuItemToDtoLevel2Converter()).map(MenuItem::getSubItems, MenuItemDtoLevel2::setSubItems));
		return myMapper.map(obj, clazz);
	}

}