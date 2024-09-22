
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import java.awt.image.BufferedImage
import java.io.InputStream
import javax.imageio.ImageIO

object ImageProvider {
    private var imgFileStream: InputStream? = null
    private var charImage: BufferedImage? = null


    @Composable
    fun ColumnScope.LoadImageFromFile(filePath: String) {
        if (imgFileStream == null)
            imgFileStream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/$filePath")


        if (imgFileStream != null) {
            if (charImage == null)
                charImage = ImageIO.read(imgFileStream)

            Image(
                bitmap = charImage!!.toComposeImageBitmap(),
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