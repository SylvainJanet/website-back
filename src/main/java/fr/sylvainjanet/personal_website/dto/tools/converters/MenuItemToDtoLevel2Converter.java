package fr.sylvainjanet.personal_website.dto.tools.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;

import fr.sylvainjanet.personal_website.dto.entities.LocalizedStringDto;
import fr.sylvainjanet.personal_website.dto.entities.PageDto;
import fr.sylvainjanet.personal_website.dto.entities.partial.MenuItemDtoLevel1;
import fr.sylvainjanet.personal_website.entities.MenuItem;

public class MenuItemToDtoLevel2Converter extends AbstractConverter<List<MenuItem>, List<MenuItemDtoLevel1>> {

	@Override
	protected List<MenuItemDtoLevel1> convert(List<MenuItem> input) {

		MenuItemToDtoLevel1Converter conv = new MenuItemToDtoLevel1Converter();

		return input.stream().map(mi -> new MenuItemDtoLevel1(mi.getId(), mi.getVersion(),
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