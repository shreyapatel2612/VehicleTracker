package com.vehicle.helper;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;

public class RuleHelper {

	public static RulesEngine rulesEngine = new DefaultRulesEngine();
	public static Rules rules = new Rules();
	
	public static void loadRules() {
		Rule engineRpmRule = new RuleBuilder()
				.name("EngineRpm")
				.description("Checking engine rpm with redline rpm")
				.when(facts -> AlertHelper.shouldTriggerEngineRpmRule(facts))
				.then(facts -> AlertHelper.triggerEngineRpmAlert(facts))
				.build();
		rules.register(engineRpmRule);
		
		Rule fuelRule = new RuleBuilder()
				.name("Fuel Rule")
				.description("Checking fuel with max fuel")
				.when(facts -> AlertHelper.shouldTriggerFuelRule(facts))
				.then(facts -> AlertHelper.triggerFuleAlert(facts))
				.build();
		rules.register(fuelRule);
		
		Rule tierRule = new RuleBuilder()
				.name("Tire Rule")
				.description("Checking pressure is between 32psi to 36psi")
				.when(facts -> AlertHelper.shouldTriggerTiersRule(facts))
				.then(facts -> AlertHelper.triggerTiresAlert(facts))
				.build();
		rules.register(tierRule);
		
		Rule engineCoolantRule = new RuleBuilder()
				.name("Engine Coolant Rule")
				.description("Checking engine coolant is low or engine light is on")
				.when(facts -> AlertHelper.shouldTriggerEngineCoolantRule(facts))
				.then(facts -> AlertHelper.triggerEngineCoolantRule(facts))
				.build();
		rules.register(engineCoolantRule);
	}
	
	public static void executeRules(Facts facts) {
		rulesEngine.fire(rules, facts);
	}
}
