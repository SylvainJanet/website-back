package fr.sylvainjanet.personal_website.dto.tools.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;

import fr.sylvainjanet.personal_website.dto.entities.LocalizedStringDto;
import fr.sylvainjanet.personal_website.dto.entities.MenuItemDto;
import fr.sylvainjanet.personal_website.dto.entities.PageDto;
import fr.sylvainjanet.personal_website.entities.MenuItem;

public class MenuToDtoConverter extends AbstractConverter<List<MenuItem>, List<MenuItemDto>> {

	@Override
	protected List<MenuItemDto> convert(List<MenuItem> input) {

		MenuItemToDtoConverter conv = new MenuItemToDtoConverter();

		return input.stream().map(mi -> new MenuItemDto((int) mi.getId(), mi.getVersion(),
				conv.convert(mi.getSubItems()), mi.getDepth(), mi.getItemRank(), mi.getMenuId(),
				new LocalizedStringDto(mi.getTitle().getId(), mi.getTitle().getVersion(), mi.getTitle().getStrings()),
				new PageDto(mi.getPage().getId(), mi.getPage().getVersion(),
						new LocalizedStringDto(mi.getPage().getTitle().getId(), mi.getPage().getTitle().getVersion(),
								mi.getPage().getTitle().getStrings()),
						new LocalizedStringDto(mi.getPage().getContent().getId(),
								mi.getPage().getContent().getVersion(), mi.getPage().getContent().getStrings()))))
				.collect(Collectors.toList());
	}

}
