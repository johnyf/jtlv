package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;

public class SMVMainProcVarInfo extends SMVContainerElementInfo {
	public SMVModuleInfo proc_desc;

	public SMVMainProcVarInfo(SMVModuleInfo proc_desc) throws SMVParseException {
		super("main", null); // this module have no initiate info...
		this.proc_desc = proc_desc;
	}

	@Override
	public SMVAbstractElementInfo clone_element() throws SMVParseException {
		throw new SMVParseException(
				"Cannot have more then a single main instance.");
	}

	@Override
	public String typeString() {
		return "";
	}

	@Override
	public void mk_fix_names() throws SMVParseException {
		this.proc_desc.mk_fix_names();
	}

	@Override
	public void mk_modules_skel(SMVModule instance_holder)
			throws SMVParseException {
		try {
			String inst_full_name = this.name; // "main"
			SMVModule inst = new SMVModule(this.proc_desc, inst_full_name);
			Env.all_modules.put(inst_full_name, inst); // registering
			this.proc_desc.mk_modules_skel(inst);
		} catch (ModuleException me) {
			// will catch, issue an error, and try to recover...
			// Env.do_error(new SMVParseException(me.getMessage(), parse_info));
			// Env.do_parsing_error(this.parse_info, me);
			throw new SMVParseException(me.getMessage(), parse_info);
		}

	}

	@Override
	public void mk_defines(SMVModule instance_holder) throws SMVParseException {
		String inst_full_name = this.name; // "main"
		SMVModule inst = (SMVModule) Env.all_modules.get(inst_full_name);
		this.proc_desc.mk_defines(inst);
	}

	@Override
	public void mk_variables(SMVModule instance_holder)
			throws SMVParseException {
		String inst_full_name = this.name; // "main"
		SMVModule inst = (SMVModule) Env.all_modules.get(inst_full_name);
		this.proc_desc.mk_variables(inst);
	}

	@Override
	public void mk_module_args(SMVModule instance_holder)
			throws SMVParseException {
		String inst_full_name = this.name; // "main"
		SMVModule inst = (SMVModule) Env.all_modules.get(inst_full_name);
		this.proc_desc.mk_module_args(inst);
	}
}
