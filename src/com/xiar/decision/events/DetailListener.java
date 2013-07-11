package com.xiar.decision.events;

import java.util.EventListener;

public interface DetailListener extends EventListener{
	public void detailEventOccured(DetailEvent event);
}
