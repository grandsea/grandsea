package com.grandsea.study.guice;

import com.google.inject.AbstractModule;
import com.grandsea.study.guice.impl.FactoryImpl;
import com.grandsea.study.guice.impl.MapCreatorImpl;

public class MapCreateModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Factory.class).to(FactoryImpl.class);
		bind(MapCreator.class).to(MapCreatorImpl.class);
	}

}
