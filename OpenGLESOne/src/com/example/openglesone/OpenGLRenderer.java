package com.example.openglesone;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class OpenGLRenderer implements Renderer {
	private float rotation = 0.0f;

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glLoadIdentity();
		gl.glClearColor(0.7f, 0.7f, 0.7f, 1.0f);
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		gl.glViewport(0, 0, width, height);
	}

	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		float vertices[] = {
				0.0f, 1.0f, 0.0f,
				-1.0f, 0.0f, 0.0f,
				1.0f, 0.0f, 0.0f,
		};

		float color[] = {
				1.0f, 0.0f, 0.0f, 1.0f,
				0.0f, 1.0f, 0.0f, 1.0f,
				0.0f, 0.0f, 1.0f, 1.0f,
		};

		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		FloatBuffer triangle = vbb.asFloatBuffer();
		triangle.put(vertices);
		triangle.position(0);

		ByteBuffer cbb = ByteBuffer.allocateDirect(color.length * 4);
		cbb.order(ByteOrder.nativeOrder());
		FloatBuffer Colors = cbb.asFloatBuffer();
		Colors.put(color);
		Colors.position(0);

		// TODO Auto-generated method stub
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glRotatef(rotation, 0.0f, 0.0f, 1.0f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangle);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, Colors);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 9);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		//rotation += 0.5;


	}

}
