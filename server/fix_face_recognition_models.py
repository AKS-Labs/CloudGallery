"""Fix face_recognition_models for Python 3.12+ (no pkg_resources)"""
import os

init_path = '/usr/local/lib/python3.12/site-packages/face_recognition_models/__init__.py'
new_content = '''import os

__author__ = "Adam Geitgey"
__version__ = "0.1.0"

_models_dir = os.path.join(os.path.dirname(__file__), "models")

def pose_predictor_model_location():
    return os.path.join(_models_dir, "shape_predictor_68_face_landmarks.dat")

def pose_predictor_five_point_model_location():
    return os.path.join(_models_dir, "shape_predictor_5_face_landmarks.dat")

def face_recognition_model_location():
    return os.path.join(_models_dir, "dlib_face_recognition_resnet_model_v1.dat")

def cnn_face_detector_model_location():
    return os.path.join(_models_dir, "mmod_human_face_detector.dat")
'''
with open(init_path, 'w') as f:
    f.write(new_content)
print('face_recognition_models patched for Python 3.12')
