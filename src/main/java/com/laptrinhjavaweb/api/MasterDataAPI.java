package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.Utils.MasterDataUtil;
import com.laptrinhjavaweb.dto.output.MasterData;

@RestController
public class MasterDataAPI {

	@GetMapping("/MasterData/{code}")
	public List<MasterData> getMasterData(@PathVariable("code") String code) {
		return MasterDataUtil.of(code).getMasterData();
	}
}
