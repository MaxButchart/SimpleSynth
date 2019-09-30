package simpleSynth;

import com.jsyn.Synthesizer;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitOscillator;

public class Oscillator {
	
	private Synthesizer synth;
	private UnitOscillator voice;

	public Oscillator(Synthesizer synth, WaveType wave) {
		
		voice = setVoice(wave);
		
		this.synth = synth;
		this.synth.add(voice);
		
	}
	
	public UnitOscillator setVoice(WaveType wave)
	{
		
		UnitOscillator waveVoice;
		
		switch (wave)
		{
			case SINE:
				waveVoice = new SineOscillator();
				break;
			case SQUARE:
				waveVoice = new SquareOscillator();
				break;
			case SAWTOOTH:
				waveVoice = new SawtoothOscillator();
				break;
			case TRIANGLE:
				waveVoice = new TriangleOscillator();
				break;
			default:
				waveVoice = new SineOscillator();
		}
		return waveVoice;
	}
	
	public UnitOscillator getVoice()
	{
		return voice;
	}
	
}

