
import android.os.Bundle
import androidx.activity.viewModels


import androidx.appcompat.app.AppCompatActivity
import com.example.stepshabittracker.TimerViewModel
import com.example.stepshabittracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<TimerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        binding.startButton.setOnClickListener {
            viewModel.startTasks()
        }

        binding.stopButton.setOnClickListener {
            viewModel.stopTasks()
        }
        */
    }
}
