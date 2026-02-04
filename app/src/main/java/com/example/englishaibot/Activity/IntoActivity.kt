package com.example.englishaibot.Activity

import android.content.Intent
import android.os.Bundle
import androidx.compose.ui.graphics.Brush

import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.englishaibot.MainActivity
import com.example.englishaibot.R
import java.nio.file.WatchEvent

class IntoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroScreenPreview(onGetStartedClick ={
                startActivity(Intent(this, MainActivity::class.java))
            }  )


        }
    }
}

@Composable
fun IntroScreenPreview(onGetStartedClick: () -> Unit){
    IntroScreen ( onGetStartedClick =  onGetStartedClick )
}



@Composable
fun IntroScreen(onGetStartedClick: () -> Unit) {

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0F2027),
            Color(0xFF203A43),
            Color(0xFF2C5364)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush)
            .padding(bottom = 40.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {

            val (titleTxt, logoRef, subtitleTxt, buttonBox) = createRefs()

            // Title
            Text(
                text = "ChatBot",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 80.dp)
                    .constrainAs(titleTxt) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            // Glowing Logo (properly constrained)
            Box(
                modifier = Modifier.constrainAs(logoRef) {
                    top.linkTo(titleTxt.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                GlowingLogo()
            }

            // Subtitle
            Text(
                text = "ChatBot App",
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium,
                color = Color.LightGray,
                modifier = Modifier.constrainAs(subtitleTxt) {
                    top.linkTo(logoRef.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            // Animated Gradient Button
            AnimatedGradientButton(
                onClick = onGetStartedClick,
                modifier = Modifier.constrainAs(buttonBox) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
        }
    }
}



@Composable
fun GetStartedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF6A11CB), // Purple
            Color(0xFF2575FC)  // Blue


        )
    )

    Box(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .height(55.dp)
            .background(
                brush = gradientBrush,
                shape = RoundedCornerShape(50.dp)
            )
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Get Started",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview
@Composable
fun showPreview(){
    IntroScreenPreview(onGetStartedClick = {})
}



@Composable
fun GlowingLogo() {

    val infiniteTransition = rememberInfiniteTransition(label = "glow")

    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(1800, easing = EaseInOut),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )

    val glowScale by infiniteTransition.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1800, easing = EaseInOut),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    Box(
        contentAlignment = Alignment.Center
    ) {

        // Outer soft glow
        Box(
            modifier = Modifier
                .size(230.dp)
                .graphicsLayer {
                    scaleX = glowScale
                    scaleY = glowScale
                    alpha = glowAlpha * 0.5f
                }
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF00C6FF),
                            Color.Transparent
                        )
                    ),
                    shape = CircleShape
                )
        )

        // Inner glow
        Box(
            modifier = Modifier
                .size(210.dp)
                .graphicsLayer {
                    scaleX = glowScale
                    scaleY = glowScale
                    alpha = glowAlpha
                }
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF6A11CB),
                            Color.Transparent
                        )
                    ),
                    shape = CircleShape
                )
        )

        // Logo (crisp, no blur)
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
        )
    }
}


@Composable
fun AnimatedGradientButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val infiniteTransition = rememberInfiniteTransition(label = "gradient")

    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing)
        ),
        label = "offset"
    )

    val gradientBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFF6A11CB),
            Color(0xFF2575FC),
            Color(0xFF00C6FF)
        ),
        start = androidx.compose.ui.geometry.Offset(offset, 0f),
        end = androidx.compose.ui.geometry.Offset(offset + 400f, 0f)
    )

    Box(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .height(55.dp)
            .background(gradientBrush, RoundedCornerShape(50.dp))
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Get Started",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
