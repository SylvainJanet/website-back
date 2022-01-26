package fr.sylvainjanet.personal_website.dto.tools.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;

import fr.sylvainjanet.personal_website.entities.MenuItem;

public class MenuItemToDtoConverter extends AbstractConverter<List<MenuItem>, List<Long>> {

	@Override
	protected List<Long> convert(List<MenuItem> input) {

		return input.stream().map(mi -> mi.getId()).collect(Collectors.toList());
	}
}
