package simpleSynth;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;

public class SimpleSynth {

	static Synthesizer synth;
	static Oscillator osc1, osc2, osc3;
	static LineOut lineOut;
	
	private static void setupSynth()
	{
		synth = JSyn.createSynthesizer();
		osc1 = new Oscillator(synth, WaveType.SINE);
		osc2 = new Oscillator(synth, WaveType.SAWTOOTH);
		osc3 = new Oscillator(synth, WaveType.SQUARE);
		
		synth.start();
		synth.add(lineOut = new LineOut());
		
		osc1.getVoice().output.connect(0, lineOut.input, 0);
		osc1.getVoice().output.connect(0, lineOut.input, 1);
		
		osc2.getVoice().output.connect(0, lineOut.input, 0);
		osc2.getVoice().output.connect(0, lineOut.input, 1);
		
		osc3.getVoice().output.connect(0, lineOut.input, 0);
		osc3.getVoice().output.connect(0, lineOut.input, 1);
		
		osc1.getVoice().frequency.set(440.0);
		osc1.getVoice().amplitude.set(0.6);
        
		osc2.getVoice().frequency.set(440.0);
		osc2.getVoice().amplitude.set(0.6);
        
		osc3.getVoice().frequency.set(440.0);
		osc3.getVoice().amplitude.set(0.6);
	}
	
	private static void testNote()
	{
		lineOut.start();

        System.out.println("You should now be hearing a sine wave. ---------");

        // Sleep while the sound is generated in the background.
        try {
            double time = synth.getCurrentTime();
            System.out.println("time = " + time);
            // Sleep for a few seconds.
            synth.sleepUntil(time + 4.0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Stop playing. -------------------");
        // Stop everything.
        synth.stop();
	}
	
	public static void main(String[] args)
	{
		setupSynth();
		testNote();
	}
	
}
