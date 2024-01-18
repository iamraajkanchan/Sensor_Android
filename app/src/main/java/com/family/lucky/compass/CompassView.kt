package com.family.lucky.compass

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class CompassView(private val context: Context) : View(context) {
    private val paint: Paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 5f
        isAntiAlias = true
    }
    private val path: Path = Path()
    private val radius = width.coerceAtLeast(height) / 2f
    private val centerX = (width / 2).toFloat()
    private val centerY = (width / 2).toFloat()
    private val needleLength = radius * 0.7
    private val needleWidth = radius * 0.1
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Draw the compass outline
        path.addCircle(centerX, centerY, radius, Path.Direction.CW)
        canvas.drawPath(path, paint)
        // Draw the needle
        val needleX = centerX + (needleLength * cos(0f)).toFloat()
        val needleY = centerY + (needleLength * sin(0f)).toFloat()
        val needlePath = Path().apply {
            moveTo(centerX, centerY)
            lineTo(needleX, needleY)
            lineTo((needleX - needleWidth / 2).toFloat(), needleY)
            lineTo((needleX + needleWidth / 2).toFloat(), needleY)
            close()
        }
        paint.color = Color.RED
        canvas.drawPath(needlePath, paint)
    }

    fun setDirection(azimuth: Double) {
        val needleAngle = -azimuth + 90.0
        path.reset()
        path.addCircle(centerX, centerY, radius, Path.Direction.CW)
        val needleX = centerX + (needleLength * cos(Math.toRadians(needleAngle))).toFloat()
        val needleY = centerY + (needleLength * sin(Math.toRadians(needleAngle))).toFloat()
        Path().apply {
            moveTo(centerX, centerY)
            lineTo(needleX, needleY)
            lineTo((needleX - needleWidth / 2).toFloat(), needleY)
            lineTo((needleX + needleWidth / 2).toFloat(), needleY)
            close()
        }
        paint.color = Color.RED
    }
}