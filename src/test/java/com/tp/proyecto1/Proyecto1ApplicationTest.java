package com.tp.proyecto1;

import com.tp.proyecto1.repository.clientes.ClienteRepository;
import com.tp.proyecto1.repository.lotePuntos.LotePuntoRepository;
import com.tp.proyecto1.repository.pasajes.FormaDePagoRepository;
import com.tp.proyecto1.repository.pasajes.PasajeVentaRepository;
import com.tp.proyecto1.repository.pasajes.ReservaRepository;
import com.tp.proyecto1.repository.pasajes.TransaccionRepository;
import com.tp.proyecto1.repository.sucursales.SucursalRepository;
import com.tp.proyecto1.repository.viajes.PaisRepository;
import com.tp.proyecto1.repository.viajes.PromocionRepository;
import com.tp.proyecto1.services.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.CommandLineRunner;

public class Proyecto1ApplicationTest {

	private Proyecto1Application proyecto1ApplicationUnderTest;

	@Before
	public void setUp() {
		proyecto1ApplicationUnderTest = new Proyecto1Application();
	}

	@Test
	public void testLoadData() {
		// Setup
		final UserService userService = null;
		final ViajeService viajeService = null;
		final VentaService ventaService = null;
		final ConfiguracionService configuracionService = null;
		final ReservaRepository reservaRepository = null;
		final ClienteRepository clienteRepository = null;
		final FormaDePagoRepository formaDePagoRepository = null;
		final PasajeVentaRepository pasajeVentaRepository = null;
		final PromocionRepository promocionRepository = null;
		final ConfiguracionService configService = null;
		final TagDestinoService tagDestinoService = null;
		final PaisRepository paisRepository = null;
		final TransaccionRepository transaccionRepository = null;
		final SucursalRepository sucursalRepository = null;
		final AsientoService asientoService = null;
		final LotePuntoRepository lotePuntoRepository = null;
		final CommandLineRunner expectedResult = null;


		// Run the test
//		final CommandLineRunner result = proyecto1ApplicationUnderTest.loadData(userService, viajeService, ventaService, configuracionService, reservaRepository, clienteRepository, formaDePagoRepository, pasajeVentaRepository, promocionRepository, configService, tagDestinoService, paisRepository, transaccionRepository, sucursalRepository, asientoService, lotePuntoRepository);
//
//		// Verify the results
//		assertEquals(expectedResult, result);
	}

	@Test
	public void testMain() {
		// Setup
		final String[] args = new String[]{};

		// Run the test
		Proyecto1Application.main(args);

		// Verify the results
	}
}
