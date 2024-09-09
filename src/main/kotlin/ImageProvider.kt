
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import javax.imageio.ImageIO

object ImageProvider {
    @Composable
    fun ColumnScope.LoadImageFromFile(filePath: String) {
        val imgFileStream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/$filePath")

        if (imgFileStream != null) {
            val bufferedImage = ImageIO.read(imgFileStream)

            Image(
                bitmap = bufferedImage.toComposeImageBitmap(),
                contentDescription = "Loaded Image",
                modifier = Modifier.weight(2f).fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        } else {
            // Handle the case when the file doesn't exist
            println("Image file not found!")
        }
    }
}