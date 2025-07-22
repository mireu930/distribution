import './App.css';
import { BrowserRouter } from 'react-router-dom';
import Topbar from './layout/topbar';
import Footer from './layout/footer';
import AppRouter from './layout/AppRouter';

function App() {
  return (
    <BrowserRouter>
    <div className="wrapper">
      <Topbar />
      {/* content */}
      <div className="content">
        <AppRouter />
      </div>
    <Footer />
    </div>
    </BrowserRouter>
   
  );
}

export default App;
