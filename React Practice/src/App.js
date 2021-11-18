import logo from './logo.svg';
import './App.css';
import Hello from './components/Hello';
import Sidebar from './components/Sidebar';
import Main from './components/Main';
import Footer from './components/Footer';
import Header from './components/Header';

function App() {
  return (
    <div className="App">
        <Hello />
        <Header />
        <div className = "row">
        <div className = "col-lg-3">
        <Sidebar />
        </div>
        <div className = "col-lg-9">
        <Main />
        </div>
        </div>
        <Footer />
    </div>
  );
}

export default App;
